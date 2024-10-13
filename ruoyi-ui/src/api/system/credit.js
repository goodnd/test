import request from '@/utils/request'

// 查询用户积分管理列表
export function listCredit(query) {
  return request({
    url: '/system/credit/list',
    method: 'get',
    params: query
  })
}

// 查询用户积分管理详细
export function getCredit(id) {
  return request({
    url: '/system/credit/' + id,
    method: 'get'
  })
}

// 新增用户积分管理
export function addCredit(data) {
  return request({
    url: '/system/credit',
    method: 'post',
    data: data
  })
}

// 修改用户积分管理
export function updateCredit(data) {
  return request({
    url: '/system/credit',
    method: 'put',
    data: data
  })
}

// 删除用户积分管理
export function delCredit(id) {
  return request({
    url: '/system/credit/' + id,
    method: 'delete'
  })
}
